//package kz.iitu.libraryManagementSystem;
//
//
//import kz.iitu.libraryManagementSystem.config.SpringConfig;
//import kz.iitu.libraryManagementSystem.controller.AuthorController;
//import kz.iitu.libraryManagementSystem.controller.BookController;
//import kz.iitu.libraryManagementSystem.controller.GenresController;
//import kz.iitu.libraryManagementSystem.controller.SubscriberController;
//import kz.iitu.libraryManagementSystem.entity.Author;
//import kz.iitu.libraryManagementSystem.entity.Book;
//import kz.iitu.libraryManagementSystem.entity.Genres;
//import kz.iitu.libraryManagementSystem.entity.Subscriber;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Scanner;
//
//public class Main {
//        private static Scanner in;
//        private static AuthorController authorController;
//        private static BookController bookController;
//        private static SubscriberController subscriberController;
//        private static GenresController genresController;
//
//    public static void main (String[]args){
//
//            in = new Scanner(System.in);
//            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//            authorController = context.getBean("authorController", AuthorController.class);
//            bookController = context.getBean("bookController", BookController.class);
//            subscriberController = context.getBean("subscriberController", SubscriberController.class);
//            genresController = context.getBean("genresController", GenresController.class);
//
//            while (true) {
//                menu();
//            }
//        }
//
//        private static void menu () {
//            System.out.println("1. Author\n" +
//                    "2. Reader\n" +
//                    "3. Exit");
//            int selector = in.nextInt();
//            switch (selector) {
//                case 1:
//                    authorAuth();
//                    break;
//                case 2:
//                    readerAuth();
//                    break;
//                case 5:
//                    System.exit(0);
//            }
//        }
//
//        private static void authorAuth(){
//            System.out.println("1. Sign in\n" +
//                    "2. Sign Up\n" +
//                    "3. Exit");
//            int selector = in.nextInt();
//            switch (selector) {
//                case 1:
//                    loginAuthor();
//                    break;
//                case 2:
//                    createAuthor();
//                    break;
//                case 5:
//                    System.exit(0);
//            }
//        }
//
//        private static void readerAuth(){
//            System.out.println("1. Sign in\n" +
//                    "2. Sign Up\n" +
//                    "3. Exit");
//            int selector = in.nextInt();
//            switch (selector) {
//                case 1:
//                    login();
//                    break;
//                case 2:
//                    createUser();
//                    break;
//                case 5:
//                    System.exit(0);
//            }
//        }
//        private static void loginAuthor () {
//            System.out.println("Log in:\nEnter the login");
//            String login = in.next();
//            System.out.println("Enter the password");
//            String password = in.next();
//            for (Author author : authorController.getAuthors()) {
//                if (author.getAuthor_email().equals(login) && author.getAuthor_password().equals(password)) {
//                    System.out.println("Welcome, " + author.getAuthor_name());
//                    menuForAuthor(author);
//                }
//            }
//        }
//
//        private static void createAuthor () {
//            System.out.println("Enter the name");
//            String name = in.next();
//            System.out.println("Enter the email");
//            String login = in.next();
//            if (authorController.getAuthors() != null) {
//                for (Author author : authorController.getAuthors()) {
//                    if (author.getAuthor_email().equals(login)) {
//                        System.out.println("Such login already exists");
//                        return;
//                    }
//                }
//            }
//            System.out.println("Enter the password");
//            String password = in.next();
//            authorController.createAuthor(new Author(name, login, password));
//            loginAuthor();
//        }
//
//        private static void createUser () {
//            System.out.println("Enter the name");
//            String name = in.next();
//            System.out.println("Enter the email");
//            String login = in.next();
//            if (subscriberController.getSubscribers() != null) {
//                for (Subscriber subscriber : subscriberController.getSubscribers()) {
//                    if (subscriber.getSubscriber_email().equals(login)) {
//                        System.out.println("Such login already exists");
//                        return;
//                    }
//                }
//            }
//            System.out.println("Enter the password");
//            String password = in.next();
//            subscriberController.createSubscribers(new Subscriber(name, login, password));
//            login();
//        }
//
//        private static void login () {
//            System.out.println("Log in:\nEnter the login");
//            String login = in.next();
//            System.out.println("Enter the password");
//            String password = in.next();
//            for (Subscriber subscriber : subscriberController.getSubscribers()) {
//                if (subscriber.getSubscriber_email().equals(login) &&
//                        subscriber.getSubscriber_password().equals(password)) {
//                    System.out.println("Welcome, " + subscriber.getSubscriber_name());
//                    menuForSubscriber(subscriber);
//                }
//            }
//        }
//
//        private static void menuForAuthor(Author author){
//            System.out.println("1. Add book\n" +
//                    "2. Add genre\n" +
//                    "3. Delete a book\n" +
//                    "4. My books\n" +
//                    "5. Exit");
//            switch (in.nextInt()) {
//                case 1:
//                    System.out.println("Enter the title");
//                    String title = in.next();
//                    for (Genres genres : genresController.getGenres()) {
//                        System.out.println(genres);
//                    }
//                    System.out.println("Enter the genre id");
//                    String id = in.next();
//                    System.out.println("Enter the description of book");
//                    String description = in.next();
//                    Genres genre = genresController.getGenreById(Long.parseLong(id)).orElse(null);
//                    bookController.createBook(new Book(title, description, author, genre));
//                    menuForAuthor(author);
//                    break;
//                case 2:
//                    System.out.println("Enter the genre name");
//                    String genre_name = in.next();
//                    genresController.createGenre(new Genres(genre_name));
//                    menuForAuthor(author);
//                    break;
//                case 3:
//                    for (Book book : bookController.getBooks()) {
//                        if (book.getAuthor().getAuthor_id().equals(author.getAuthor_id())) {
//                            System.out.println(book);
//                        }
//                    }
//                    System.out.println("Enter the post id that you want to delete");
//                    int postID = in.nextInt();
//                    bookController.deleteBook(postID);
//                    menuForAuthor(author);
//                    break;
//                case 4:
//                    for (Book book : bookController.getBooks()) {
//                        if (book.getAuthor().getAuthor_id().equals(author.getAuthor_id())) {
//                            System.out.println(book);
//                        }
//                    }
//                    menuForAuthor(author);
//                    break;
//                case 5:
//                    System.exit(0);
//                    break;
//            }
//        }
//
//        private static void menuForSubscriber (Subscriber subscriber){
//            System.out.println("1. All authors\n" +
//                    "2. Followed authors\n" +
//                    "3. Search\n" +
//                    "4. Filter by author\n" +
//                    "5. Filter by genre\n" +
//                    "6. Exit");
//            switch (in.nextInt()) {
//                case 1:
//                    for (Author author : authorController.getAuthors()) {
//                        System.out.println(author);
//                    }
//                    System.out.println("1. Follow\n" +
//                            "2. Back");
//                    int choice = in.nextInt();
//                    if (choice == 2) {
//                        menuForSubscriber(subscriber);
//                    } else if (choice == 1) {
//                        System.out.println("Enter the id of author");
//                        int authorId = in.nextInt();
//                        for (Author author : authorController.getAuthors()) {
//                            if (author.getAuthor_id() == authorId) {
//                                subscriber.getPublishers().add(author);
//                                author.getSubscribers().add(subscriber);
//                                subscriberController.update(subscriber);
//                            }
//                        }
//                        menuForSubscriber(subscriber);
//                    }
//                    break;
//                case 2:
//                    for (Author author : subscriber.getPublishers()) {
//                        System.out.println(author);
//                    }
//                    menuForSubscriber(subscriber);
//                case 3:
//                    in.nextLine();
//                    System.out.println("Search: ");
//                    String search = in.nextLine();
//                    List<Book> results = bookController.search(search);
//                    for (Book book: results){
//                        System.out.println(book);
//                    }
//                    menuForSubscriber(subscriber);
//                case 4:
//                    for (Author author : authorController.getAuthors()) {
//                        System.out.println(author);
//                    }
//                    System.out.println("Enter author id: ");
//                    Long id = in.nextLong();
//                    List<Book> books = bookController.findByAuthor(id);
//                    for (Book book: books){
//                        System.out.println(book);
//                    }
//                    menuForSubscriber(subscriber);
//                case 5:
//                    for (Genres genres : genresController.getGenres()) {
//                        System.out.println(genres);
//                    }
//                    System.out.println("Enter genre id: ");
//                    Long genre_id = in.nextLong();
//                    List<Book> result = bookController.findByGenre(genre_id);
//                    for (Book book: result){
//                        System.out.println(book);
//                    }
//                    menuForSubscriber(subscriber);
//                case 6:
//                   System.exit(0);
//                   break;
//            }
//
//        }
//    }
//
