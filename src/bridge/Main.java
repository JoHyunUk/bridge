package bridge;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 오징어 게임의 다리 건너기
		// 건너야 될 다리가 12개가 있다
		// 12개의 다리를 만들자(1, 2)
		ArrayList<Integer> bList = new ArrayList<Integer>();
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 12; i++) {
			bList.add(rnd.nextInt(2) + 1);
			System.out.print(bList.get(i));
		}
		System.out.println();
		// 끝까지 성공인 아닌지를 체크하기 위한 임시 변수
		boolean isSuccess = true;
		// 여러 사람
		int users = 1;
		int step = 0;
		// 첫번째 다리 부터 시작 해서
		for (; step < bList.size();) {
			// 오른쪽으로 갈지 왼쪽으로 갈지를 선택(1, 2)
			// 둘 중에 강화 유리를 선택하면 다음 다리
			System.out.println((step+1) + "번째 다리");
			System.out.println(users + "번 사람 출발 ");
			System.out.print("왼(1)/오른(2): ");
			int u = sc.nextInt();   // 예외 처리를 해주면 좋겠다
			if (bList.get(step) == u) {
				System.out.println((step+1) + "번째 다리 통과");
				System.out.println();
				step++;   // 다음 다리
			} else {
				System.out.println(users + "번 탈락");
				System.out.println();
				if (users == 8) {
					isSuccess = false;
					break;
				}
				users++;
			}
		}
		// 강화 유리를 선택을 안하면 생명 -1(생명의 갯수를 설정)
		// ... 마지막 10개 다리를 다 건너면 산다
		// 만약에 isSuccess 가 true 이면 산거고 아니면 죽은거다
		if (isSuccess) {
			System.out.println("생존 하였습니다. ");
		} else {
			System.out.println("게임오버");
		}
	}

}