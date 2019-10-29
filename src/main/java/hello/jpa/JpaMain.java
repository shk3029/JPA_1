package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // code
        List<Member> result = em.createQuery("select m from Member as m", Member.class)
                        .setFirstResult(5)
                        .setMaxResults(8)
                        .getResultList();
        result.stream().forEach(x-> System.out.println("name" + x.getName()));



      /*  Member member = em.find(Member.class, 1L);
        System.out.println(member.getId());
        System.out.println(member.getName());
        member.setName("ksjsx");*/

        tx.commit();

        em.close();
        emf.close();

    }
}
