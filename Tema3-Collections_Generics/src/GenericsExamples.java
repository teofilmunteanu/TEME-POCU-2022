public class GenericsExamples {
    public static void Ex1(){
        System.out.println("With generics:");
        genericVideos();
        System.out.println();

        genericBooks();
        System.out.println();

        genericNewspapers();
        System.out.println();


        System.out.println("Without generics:");
        nonGenericVideos();
        System.out.println();

        nonGenericBooks();
        System.out.println();

        nonGenericNewspapers();
        System.out.println();
    }

    public static void genericVideos(){
        LibraryGenerics<Video> videoLibrary = new LibraryGenerics<>();

        Video vid1 = new Video("video1", "https://youtu.be/s2MJ1cjXqmM");
        Video vid2 = new Video("video2", "https://youtu.be/adV8-_hgL4g");

        videoLibrary.addMedia(vid1);
        videoLibrary.addMedia(vid2);

        System.out.println(videoLibrary.retrieveFirst());
        System.out.println(videoLibrary.retrieveLast());
    }

    public static void genericBooks(){
        LibraryGenerics<Book> bookLibrary = new LibraryGenerics<>();

        String  content1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Aliquam auctor, sapien eu faucibus porttitor, orci elit scelerisque libero, a lacinia orci arcu lobortis est. " +
                "Duis ex libero, ultrices ut viverra a, ultrices sed justo. ";
        Book book1 = new Book("book1", "Markus I Dunno", content1);

        String content2 = "Etiam accumsan a nunc eget gravida. Cras posuere ultrices eros eu placerat. Cras sit amet consequat orci. " +
                "Curabitur rhoncus purus nec nulla tristique vehicula. Quisque vel ullamcorper ex. " +
                "Vestibulum laoreet ipsum eu leo sagittis, sed lacinia eros rutrum. Donec pellentesque eros diam, ut ultrices enim aliquet vitae. ";
        Book book2 = new Book("book2", "William J Whoever", content2);

        bookLibrary.addMedia(book1);
        bookLibrary.addMedia(book2);

        System.out.println(bookLibrary.retrieveFirst());
        System.out.println(bookLibrary.retrieveLast());
    }

    public static void genericNewspapers(){
        LibraryGenerics<Newspaper> newspaperLibrary = new LibraryGenerics<>();

        String  content1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Aliquam auctor, sapien eu faucibus porttitor, orci elit scelerisque libero, a lacinia orci arcu lobortis est. " +
                "Duis ex libero, ultrices ut viverra a, ultrices sed justo. ";
        Newspaper np1 = new Newspaper("Newspaper1", "11.7.2022", content1);

        String content2 = "Etiam accumsan a nunc eget gravida. Cras posuere ultrices eros eu placerat. Cras sit amet consequat orci. " +
                "Curabitur rhoncus purus nec nulla tristique vehicula. Quisque vel ullamcorper ex. " +
                "Vestibulum laoreet ipsum eu leo sagittis, sed lacinia eros rutrum. Donec pellentesque eros diam, ut ultrices enim aliquet vitae. ";
        Newspaper np2 = new Newspaper("Newspaper2", "17.7.2022", content2);

        newspaperLibrary.addMedia(np1);
        newspaperLibrary.addMedia(np2);

        System.out.println(newspaperLibrary.retrieveFirst());
        System.out.println(newspaperLibrary.retrieveLast());
    }


    public static void nonGenericVideos(){
        LibraryNoGenerics videoLibrary = new LibraryNoGenerics();

        Video vid1 = new Video("video3", "https://youtu.be/s2MJ1cjXqmM");
        Video vid2 = new Video("video4", "https://youtu.be/adV8-_hgL4g");

        videoLibrary.addMedia(vid1);
        videoLibrary.addMedia(vid2);

        System.out.println(videoLibrary.retrieveFirst());
        System.out.println(videoLibrary.retrieveLast());
    }

    public static void nonGenericBooks(){
        LibraryNoGenerics bookLibrary = new LibraryNoGenerics();

        String  content1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Aliquam auctor, sapien eu faucibus porttitor, orci elit scelerisque libero, a lacinia orci arcu lobortis est. " +
                "Duis ex libero, ultrices ut viverra a, ultrices sed justo. ";
        Book book1 = new Book("book3", "Markus I Dunno", content1);

        String content2 = "Etiam accumsan a nunc eget gravida. Cras posuere ultrices eros eu placerat. Cras sit amet consequat orci. " +
                "Curabitur rhoncus purus nec nulla tristique vehicula. Quisque vel ullamcorper ex. " +
                "Vestibulum laoreet ipsum eu leo sagittis, sed lacinia eros rutrum. Donec pellentesque eros diam, ut ultrices enim aliquet vitae. ";
        Book book2 = new Book("book4", "William J Whoever", content2);

        bookLibrary.addMedia(book1);
        bookLibrary.addMedia(book2);

        System.out.println(bookLibrary.retrieveFirst());
        System.out.println(bookLibrary.retrieveLast());
    }

    public static void nonGenericNewspapers(){
        LibraryNoGenerics newspaperLibrary = new LibraryNoGenerics();

        String  content1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Aliquam auctor, sapien eu faucibus porttitor, orci elit scelerisque libero, a lacinia orci arcu lobortis est. " +
                "Duis ex libero, ultrices ut viverra a, ultrices sed justo. ";
        Newspaper np1 = new Newspaper("Newspaper3", "11.7.2022", content1);

        String content2 = "Etiam accumsan a nunc eget gravida. Cras posuere ultrices eros eu placerat. Cras sit amet consequat orci. " +
                "Curabitur rhoncus purus nec nulla tristique vehicula. Quisque vel ullamcorper ex. " +
                "Vestibulum laoreet ipsum eu leo sagittis, sed lacinia eros rutrum. Donec pellentesque eros diam, ut ultrices enim aliquet vitae. ";
        Newspaper np2 = new Newspaper("Newspaper4", "17.7.2022", content2);

        newspaperLibrary.addMedia(np1);
        newspaperLibrary.addMedia(np2);

        System.out.println(newspaperLibrary.retrieveFirst());
        System.out.println(newspaperLibrary.retrieveLast());
    }
}
