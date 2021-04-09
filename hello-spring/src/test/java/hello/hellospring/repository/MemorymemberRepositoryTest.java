package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemorymemberRepositoryTest {

    MemoryMemberRespository repository = new MemoryMemberRespository();

    // 테스트는 데이터가 서로 의존관계가 없어야함
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    // 기존 로컬 서버 중단하고 메소드 실행
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(result, member); //junit
        assertThat(member).isEqualTo(result); // asserj static 임포트
//        System.out.println("result = "+(result == member));
    }

    @Test
    public  void  findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
//        System.out.println(member1);
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("speing2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
//        System.out.println("result = "+result+"member1:"+member1);
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public  void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
//        System.out.println(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }



}
