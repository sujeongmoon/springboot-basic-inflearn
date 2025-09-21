package hello.hello_spring.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hello_spring.domain.Member;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository memberRepository = new MemoryMemberRepository();

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");

		memberRepository.save(member);
		Member result = memberRepository.findById(member.getId()).get();
		// System.out.println("result = " + (result == member));
		// Assertions.assertEquals(member, result);
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		memberRepository.save(member2);

		Member result = memberRepository.findByName("spring1").get();

		assertThat(result).isEqualTo(member1);

	}

	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		memberRepository.save(member2);

		List<Member> result = memberRepository.findAll();

		assertThat(result.size()).isEqualTo(2);
	}

}
