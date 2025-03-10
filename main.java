
public static void main(String[] args) {
    MinHeap minHeap = new MinHeap();

    String[] names = {"Sally", "Zelda", "Adam", "Greg", "Mohamid", "Kusha"};
    boolean session = true;

    while (session) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Menu");
        System.out.println("1. Populate the Min Heap with default names");
        System.out.println("2. Add a name to the Min Heap");
        System.out.println("3. Print Min Heap");
        System.out.println("4. Exit\n");
        int option = scanner.nextInt();

        switch (option) {
            case 1: // populate data
                    System.out.print("The default name list is: " );
                    for (int i = 0; i < names.length; i++) {
                        System.out.print(names[i] + ", ");   
                    }
                    System.out.println("\n");
                // Insert values into the min heap
                for (int i = 0; i < names.length; i++) {
                    minHeap.insert(names[i]);
                }
                
                break;
            case 2: // add name
                System.out.println("Enter a name to add to the Min Heap:");
                String name = scanner.next();
                minHeap.insert(name);
                break;

            case 3: // print heap
                System.out.println("Names in order from the Min Heap:");
                // Extract and print the minimum values from the heap
                for (int i = 0; i < names.length; i++) {
                    System.out.println(minHeap.extractMin());
                }
                break;

            case 4: // exit
                session = false;
                break;
    
            default:
                break;
        }


    }
}


