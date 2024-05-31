package co.develhope.crudrestapi2.repository;

import co.develhope.crudrestapi2.entity.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-prog-languages", collectionResourceRel = "languages", itemResourceRel = "language")
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {

}
