package az.atlacademy.news.repository;

import az.atlacademy.news.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {

    Optional<News> findByIdAndIsActiveIsTrueAndIsDeletedIsFalse(Long newsId);//named
    Optional<News> findByTitle(String title);
    //Optional<Customer> findByEmail(String email);


    @Query("select n from News n where n.isActive=:param1 and n.id=:newsId")//etity based
    Optional<News> tapMeneXeberi(@Param("param1") boolean isActive, Long newsId);

    @Query(value = "select * from news n where n.is_active=:param1 and n.id=:newsId" ,nativeQuery = true)//native query
    Optional<News> findNews(Long newsId);


}
