package sample;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.SQLException;
import java.util.List;

public class SqlMinion {

    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("sample/hibernate.cfg.xml").build();
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    SessionFactory factory = meta.getSessionFactoryBuilder().build();
    Session session = factory.openSession();
    Transaction t = session.beginTransaction();


    public SqlMinion() {}


    public void insertworker(String name, int age, String adress, int income) {

        Worker worker = new Worker();
        worker.setAdress(adress);
        worker.setAge(String.valueOf(age));
        worker.setIncome(String.valueOf(income));
        worker.setName(name);
        session.save(worker);
        t.commit();
        System.out.println(worker.toString() + "saved successfully");
   //     factory.close();
     //   session.close();

    }

    public void changeworker(int id, String target, String payload) {

        long employeeId = id;

        Worker worker = (Worker) session.get(Worker.class, employeeId);
        if (target.equals("age"))
            worker.setAge(payload);
        else if (target.equals("adress"))
            worker.setAdress(payload);
        else if (target.equals("name"))
            worker.setName(payload);
        else if (target.equals("income"))
            worker.setIncome(payload);
        session.update(worker);
        t.commit();
        System.out.println("Updated Record");
       // factory.close();
       // session.close();
    }

    public void deleteemployee(int id) {
        long employeeId = id;
        Worker worker1 = (Worker) session.get(Worker.class, employeeId);
        session.delete(worker1);
        t.commit();
        System.out.println("Deleted Record");
       // factory.close();
       // session.close();

    }

    public String pullEveryone() {

        List employees = session.createQuery("FROM sample.worker").list();

        StringBuilder endgamepaloki = new StringBuilder(" ");
        if (employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {
                endgamepaloki.append(" " + employees.get(i).toString() + " ");
            }
        }
        return String.valueOf(endgamepaloki);
    }

    public String pullsomeone(String filter, String criteria) {

        List<Worker> arrayList1 = session.createQuery("FROM sample.worker").list();

        StringBuilder endgamepaloki = new StringBuilder(" ");
        if (arrayList1.size() > 0) {
            for (int i = 0; i < arrayList1.size(); i++) {
                if (filter.equals("name")) {
                    if (criteria.equals(arrayList1.get(i).getName())) {
                        endgamepaloki.append(" " + arrayList1.get(i).getName());
                    }
                } else if (filter.equals("age")) {
                    if (criteria.equals(arrayList1.get(i).getAge())) {
                        endgamepaloki.append(" " + arrayList1.get(i).getAge());
                    }
                } else if (filter.equals("adress")) {
                    if (criteria.equals(arrayList1.get(i).getAdress())) {
                        endgamepaloki.append(" " + arrayList1.get(i).getAdress());
                    }
                } else if (filter.equals("income")) {
                    if (criteria.equals(arrayList1.get(i).getIncome())) {
                        endgamepaloki.append(" " + arrayList1.get(i).getIncome());
                    }
                }
            }
        }
        return String.valueOf(endgamepaloki);
    }
}
