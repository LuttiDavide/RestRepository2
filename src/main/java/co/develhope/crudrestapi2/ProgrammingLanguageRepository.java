package co.develhope.crudrestapi2;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-prog-languages", collectionResourceRel = "languages")
public interface ProgrammingLanguageRepository extends PagingAndSortingRepository<ProgrammingLanguage, Long> {
}
