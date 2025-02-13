package s_lab.sichniy_andriy.portier_digital;


import java.util.ArrayList;
import java.util.List;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import s_lab.sichniy_andriy.portier_digital.model.Article;
import s_lab.sichniy_andriy.portier_digital.model.Company;
import s_lab.sichniy_andriy.portier_digital.model.Contact;
import s_lab.sichniy_andriy.portier_digital.model.Skill;
import s_lab.sichniy_andriy.portier_digital.repository.ArticlesRepository;
import s_lab.sichniy_andriy.portier_digital.repository.CompaniesRepository;
import s_lab.sichniy_andriy.portier_digital.repository.ContactsRepository;
import s_lab.sichniy_andriy.portier_digital.repository.SkillsRepository;

@Component
public class InitUtils implements CommandLineRunner {

    private final ContactsRepository contactsRepository;
    private final SkillsRepository skillsRepository;
    private final CompaniesRepository companiesRepository;
    private final ArticlesRepository articlesRepository;

    private final Faker faker;

    public InitUtils(
            @Autowired ContactsRepository contactsRepository,
            @Autowired SkillsRepository skillsRepository,
            @Autowired CompaniesRepository companiesRepository,
            @Autowired ArticlesRepository articlesRepository
    ) {
        this.faker = new Faker();
        this.contactsRepository = contactsRepository;
        this.skillsRepository = skillsRepository;
        this.companiesRepository = companiesRepository;
        this.articlesRepository = articlesRepository;
    }


    @Override
    public void run(String... args) {
        initArticles(faker.number().numberBetween(15, 25));
        initCompanies(faker.number().numberBetween(5, 10));
        initContacts();
        initSkills(faker.number().numberBetween(9, 12));
    }

    private void initArticles(int n) {
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Article article = new Article();
            article.setTitle(faker.book().title());
            article.setContent(faker.text().text(500, 2000));
            articles.add(article);
        }
        articlesRepository.saveAllAndFlush(articles);
    }

    private void initCompanies(int n) {
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Company company = new Company();
            company.setTitle(faker.company().name());
            company.setPosition(faker.hacker().adjective() + " " + faker.hacker().noun() + " " + faker.hacker().verb());
            companies.add(company);
        }
        companiesRepository.saveAllAndFlush(companies);
    }

    private void initContacts() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setType("Instagram");
        contact1.setAddress(faker.internet().domainName());
        contacts.add(contact1);
        Contact contact2 = new Contact();
        contact2.setType("Email");
        contact2.setAddress(faker.internet().emailAddress());
        contacts.add(contact2);
        Contact contact3 = new Contact();
        contact3.setType("Twitter");
        contact3.setAddress(faker.twitter().userName());
        contacts.add(contact3);
        Contact contact4 = new Contact();
        contact4.setType("Facebook");
        contact4.setAddress(faker.twitter().userName());
        contacts.add(contact4);
        contactsRepository.saveAllAndFlush(contacts);
    }

    private void initSkills(int n) {
        List<Skill> skills = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Skill skill = new Skill();
            String tmpTitle;
            boolean flag;
            do {
                tmpTitle = faker.job().keySkills();
                String finalTmpTitle = tmpTitle;
                flag = skills.stream().anyMatch(item -> item.getTitle().equals(finalTmpTitle));
            } while (flag);
            skill.setTitle(tmpTitle);
            skill.setDescription(faker.yoda().quote());
            skills.add(skill);
        }
        skillsRepository.saveAllAndFlush(skills);
    }
}
