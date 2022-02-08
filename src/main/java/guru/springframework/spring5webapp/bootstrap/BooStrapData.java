package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BooStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BooStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pearson = new Publisher("Pearson Education");
        publisherRepository.save(pearson);
        Publisher wiley = new Publisher("Wiley");
        publisherRepository.save(wiley);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        ddd.addAuthor(eric);
        ddd.setPublisher(pearson);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pearson);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        noEJB.addAuthor(rod);
        noEJB.setPublisher(wiley);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(wiley);

        Author breasnahan = new Author("Christine", "Bresnahan");
        Author blum = new Author("Richard", "Blum");
        Book linux = new Book("Linux+ Study Guide", "513908510");
        linux.addAuthor(breasnahan);
        linux.addAuthor(blum);
        linux.setPublisher(wiley);

        authorRepository.save(breasnahan);
        authorRepository.save(blum);
        bookRepository.save(linux);
        publisherRepository.save(wiley);

        System.out.println("Started in Bootstrap");
        System.out.println("Books repo: " + bookRepository.count());
        System.out.println("Authors repo: " + authorRepository.count());
        System.out.println("Publishers repo: " + publisherRepository.count());
    }
}
