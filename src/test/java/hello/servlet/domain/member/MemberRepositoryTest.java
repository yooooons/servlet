package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given - 이런게 주워졌을때
        Member member = new Member("hello", 20);

        //when - 이런게 실행됐을때
        Member savedMember = memberRepository.save(member);

        //then - 이렇게 해야된다
        Member findMember = memberRepository.findById(savedMember.getId());

        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);







    }
}
