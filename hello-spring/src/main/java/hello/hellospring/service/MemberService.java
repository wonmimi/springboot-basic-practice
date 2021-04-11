package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRespository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRespository();
    /*
        회원가입
     */
    public Long join(Member member){

//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {

        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    // 중복 회원 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).
        ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*
        전체 회원 조회
     */

    public List fineMembers(){
        return memberRepository.findAll();
    }

    public Optional findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
