package s_lab.sichniy_andriy.portier_digital.service;

import java.util.List;
import org.springframework.data.domain.Page;
import s_lab.sichniy_andriy.portier_digital.model.dto.ArticleDto;
import s_lab.sichniy_andriy.portier_digital.model.dto.SubscriberDto;


public interface BlogService {

    List<ArticleDto> getAllArticles();

    Page<ArticleDto> getArticlePage(int page, int size, String col);

    ArticleDto getArticleById(long id);

    boolean deleteArticle(long id);

    long saveArticle(ArticleDto articleDto);

    List<SubscriberDto> getAllSubscribers();

    Page<SubscriberDto> getSubscriberPage(int page, int size, String col);

    long saveSubscriber(SubscriberDto subscriberDto);

    boolean deleteSubscriber(long id);

}
