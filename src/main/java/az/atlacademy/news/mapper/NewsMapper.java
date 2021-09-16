package az.atlacademy.news.mapper;


import az.atlacademy.news.dto.NewsDto;
import az.atlacademy.news.entity.Author;
import az.atlacademy.news.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(target = "author", source = "author", qualifiedByName = "authorFullName")
    @Mapping(target = "newsTitle", source = "title",qualifiedByName = "titleUpperCase")
    @Mapping(target = "visitCount",source = "visitCount",ignore = true)

     NewsDto newsEntityToDto(News news);

    @Named("authorFullName")
    default String getFullName(Author author) {
        return author.getName() + " " + author.getSurname();
    }

    @Named("titleUpperCase")
    default String getUpperCase(String title) {
        return title.toUpperCase();
    }

}


