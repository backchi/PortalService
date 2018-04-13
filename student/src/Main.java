import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        ArrayList<Student> S = new ArrayList<Student>();
        ArrayList<StudentGrade> SL = new ArrayList<StudentGrade>();

        Scanner sc = new Scanner(System.in);
        Student[] s = new Student[3];
        StudentGrade[] sg = new StudentGrade[5];

        System.out.println("3명의 학번, 이름, 생년, 성별을 차례대로 입력해주세요!");

        for (int i = 0; i <= 2; i++) {
            s[i] = new Student();
            System.out.print("학번 입력 :");
            s[i].student_num = sc.nextInt();
            System.out.print("이름 입력 :");
            s[i].name = sc.next();
            System.out.print("생년 입력 :");
            s[i].birth = sc.nextInt();
            System.out.print("성별 입력 :");
            s[i].sex = sc.next().charAt(0);
            S.add(s[i]);
        }
        System.out.println("3명의 점수를 차례대로 입력해주세요!");
        for (int i = 0; i <= 2; i++) {
            sg[i] = new StudentGrade();
            System.out.print(s[i].name + "의 국어 점수 :");
            sg[i].korean = sc.nextInt();
            System.out.print(s[i].name + "의 영어 점수 :");
            sg[i].english = sc.nextInt();
            System.out.print(s[i].name + "의 수학 점수 :");
            sg[i].math = sc.nextInt();
            SL.add(sg[i]);
        }

        for (int i = 0; i <= 2; i++) {
            System.out.print("[ 학번 :"+ s[i].student_num
                    + " 이름 :" + s[i].name
                    + " 생년 :" +s[i].birth
                    + " 성별 :" + s[i].sex );
            System.out.println(" ]의 총점과 평균 계산입니다.");
            int sum = sg[i].korean + sg[i].english + sg[i].math;
            int average = sum/3;
            System.out.println("총점은 : " + sum + ", 평균은 : "+ average);
        }
    }
}
