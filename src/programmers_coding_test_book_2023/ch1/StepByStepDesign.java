package programmers_coding_test_book_2023.ch1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * packageName    : programmers_coding_test_book_2023.ch1 fileName       : StepByStepDesign author         : asdfz date
 *          : 2023-12-19 description    : =============================================== DATE              AUTHOR
 * NOTE ----------------------------------------------- 2023-12-19        asdfz       최초 생성
 */
public class StepByStepDesign {
    public static void main(String[] args) {
        Person person1 = new Person("홍길동");
        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));

        Person person2 = new Person("김철수");
        person2.addPhoneNumber(new PhoneNumber("010-2345-0246"));

        Person person3 = new Person("이영희");
        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person3);

        System.out.println(phoneBook.search(new PhoneNumber("01012345678")));
        System.out.println(phoneBook.search(new PhoneNumber("010-2345-6789")));
        System.out.println(phoneBook.search(new PhoneNumber("01023450246")));
        System.out.println(phoneBook.search(new PhoneNumber("01013579135")));
        System.out.println(phoneBook.search(new PhoneNumber("01000000000")));

    }
    //숫자가 아닌 문자들만 제거

    //phonNumber.replaceAll("[^0-9], "");

    //별도의 클래스를 작성해서 전화번호를 나타내는 문자열이라는 것을 알려줄 수 있음
    private static class PhoneNumber{

        public final String phonNumber;

        public PhoneNumber(String rawPhoneNumber) {
            this.phonNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof PhoneNumber)) {
                return false;
            }
            return phonNumber.equals(((PhoneNumber) obj).phonNumber);
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "phonNumber='" + phonNumber + '\'' +
                    '}';
        }

    }


    private static class Person {

        //2-0. 변수 선언
        // name, numbers는 값이 생성 후 변경되지 않게 final로 선언
        // List 처럼 외부에서 접근해 임의로 값을 바꿀 수 있는 경우는 private으로 선언하고,
        // 내부에서 의도한 대로만 해당 객체를 사용할 수 있게 해줌
        // final String 처럼 불변인 객체는 외부에서 읽기만 할 수 있음으로 public으로 선언해도 됨
        public final String name;
        private final List<PhoneNumber> numbers;

        public Person(String name) {
            this.name = name;
            numbers = new ArrayList<>();
        }

        //2-1. 전화번호 추가 메서드
        public void addPhoneNumber(PhoneNumber number) {
            numbers.add(number);
        }


        //3-1.
        public boolean hasPhoneNumber(PhoneNumber number) {
            return numbers.contains(number);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", numbers=" + numbers +
                    '}';
        }
    }

    private static class PhoneBook {
        private final Set<Person> people;

        private PhoneBook() {
            people = new HashSet<>();
        }

        public void addPerson(Person person) {
            people.add(person);
        }

        public Person search(PhoneNumber number) {
            return people.stream()
                    .filter(p -> p.hasPhoneNumber(number))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public String toString() {
            return "PhoneBook{" +
                    "people=" + people +
                    '}';
        }
    }


}
