package lab5;

import java.util.*;
import java.io.*;

public class EiuGrdsa2 {
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = rd.nextInt();
        int p = rd.nextInt();
        int m = rd.nextInt();

        HashMap<Integer, Student> map = new HashMap<>();
        List<Integer> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int studentId = rd.nextInt();
            map.put(studentId, new Student(studentId, p));
            studentList.add(studentId);
        }

        HashSet<Integer> validProblems = new HashSet<>();
        for (int i = 0; i < p; i++) {
            validProblems.add(rd.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int studentId = rd.nextInt();
            int homeworkId = rd.nextInt();
            int score = rd.nextInt();

            if (!map.containsKey(studentId)) continue;
            if (!validProblems.contains(homeworkId)) continue;

            Student s = map.get(studentId);

            s.count++;  // số lần nộp hợp lệ

            // cập nhật điểm cao nhất cho bài
            int old = s.best.getOrDefault(homeworkId, 0);
            if (score > old)
                s.best.put(homeworkId, score);
        }

        List<Student> result = new ArrayList<>();

        for (int id : studentList) {
            Student s = map.get(id);

            int sum = 0;
            for (int prob : validProblems) {
                sum += s.best.getOrDefault(prob, 0);
            }

            s.avg = sum / p;

            result.add(s);
        }

        result.sort((a, b) -> {
            if (a.avg != b.avg) return b.avg - a.avg;
            if (a.count != b.count) return a.count - b.count;
            return a.studentId - b.studentId;
        });

        for (Student s : result) {
            sb.append(s.studentId).append(" ").append(s.avg).append(" ").append(s.count).append("\n");
        }

        System.out.print(sb);
    }

    static class Student {
        int studentId;
        int count = 0;
        int avg = 0;
        HashMap<Integer, Integer> best;

        public Student(int id, int p) {
            this.studentId = id;
            this.best = new HashMap<>();
        }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String temp;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else
                        tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
