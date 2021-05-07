package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
JpaRepository 인터페이스를 extends 한다 (interface  -> interface : extends)
interface 는 다중상속이 된다.
스프링 데이터가 제공하는 JpaRepository 가 자동으로 SpringDataJpaMemberRepository 를 확인하고 구현체로 만들어 스프링빈에 자동 등록
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 인터페이스 이름으로 추가
    //  = JPQL : select m from Member m where m.name =?
    @Override
    Optional<Member> findByName(String name);

//    ex) And , Or .. 활용
//    Optional<Member> findByNameAndID(String name, Long id);

}
