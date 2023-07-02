package hello.springexercise02.mapper.member;

import hello.springexercise02.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void saveMember(Member member);

    Member findByLoginIdMember(String loginId);
}
