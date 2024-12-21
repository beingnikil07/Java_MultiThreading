// SharedResource acts as the shared object for communication between producer and consumer threads
class SharedResource {
    private int data; // Stores the data produced by the producer
    private boolean hasData; // Indicates if data is available for consumption

    // Method to produce data
    public synchronized void produce(int value) {
        // Wait until there is no data (hasData is false)
        while (hasData) {
            try {
                wait(); // Release the lock and wait until notified
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupt status
            }
        }
        // Produce new data
        data = value;
        hasData = true; // Set hasData to true, signaling data is available
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer thread that data is available
    }

    // Method to consume data
    public synchronized int consume() {
        // Wait until there is data to consume (hasData is true)
        while (!hasData) {
            try {
                wait(); // Release the lock and wait until notified
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupt status
            }
        }
        // Consume the data
        hasData = false; // Set hasData to false, signaling data has been consumed
        System.out.println("Consumed: " + data);
        notify(); // Notify the producer thread that space is available for new data
        return data; // Return the consumed data
    }
}

// Producer class, which produces data to be consumed
class Producer implements Runnable {
    private SharedResource resource; // Reference to the shared resource

    // Constructor to initialize the shared resource
    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        // Produce 10 items
        for (int i = 0; i < 10; i++) {
            resource.produce(i); // Call the produce method to add data
        }
    }
}

// Consumer class, which consumes data produced by the producer
class Consumer implements Runnable {
    private SharedResource resource; // Reference to the shared resource

    // Constructor to initialize the shared resource
    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        // Consume 10 items
        for (int i = 0; i < 10; i++) {
            int value = resource.consume(); // Call the consume method to retrieve data
        }
    }
}

// Main class to start the producer and consumer threads
public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(); // Create the shared resource

        // Create and start the producer thread
        Thread producerThread = new Thread(new Producer(resource));

        // Create and start the consumer thread
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start(); // Start the producer thread
        consumerThread.start(); // Start the consumer thread
    }
}
