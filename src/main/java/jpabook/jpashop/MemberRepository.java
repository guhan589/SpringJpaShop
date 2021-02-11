package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext //영속성 컨텍스트: 엔티티를 영구적으로 저장하는 환경
    private EntityManager em; //EntityManager: 엔티티를 저장, 수정, 삭제, 조회등 엔티티와 관련된 작업을 수행

    public Long save(Member member) {
        em.persist(member); //persist: 저장:영속
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id); //find 조회:영속
                                        //em.find를 통해 새로 DB에서 조회된 엔티티는 영속성 컨텍스트에서 관리한다.
    }
}
