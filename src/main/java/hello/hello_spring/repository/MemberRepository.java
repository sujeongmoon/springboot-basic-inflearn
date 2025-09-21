package hello.hello_spring.repository;

import java.util.List;
import java.util.Optional;

import hello.hello_spring.domain.Member;

public interface MemberRepository {
	Member save(Member member);

	Optional<Member> findById(long id);

	Optional<Member> findByName(String name);

	List<Member> findAll();
}
