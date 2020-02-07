package Spring;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "BuddyInfo", path = "BuddyInfo")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {

    BuddyInfo findById(Integer id);
    BuddyInfo findByName(@Param("name") String name);
    BuddyInfo findByAddress(@Param("address") String address);
    BuddyInfo findByPhoneNumber(@Param("phoneNumber") long phoneNumber);
}