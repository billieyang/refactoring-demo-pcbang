package kr.ac.chungnam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.ac.chungnam.domain.PcBang;
import kr.ac.chungnam.domain.Player;
import kr.ac.chungnam.service.PcBangService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PcBangApplication {
    private static List<PcBang> readPcBangsFromResourceFile() throws FileNotFoundException {
        String resourceFilePath = PcBangApplication.class.getClassLoader().getResource("pc-bangs.json").getFile();
        return new Gson().fromJson(new FileReader(resourceFilePath), new TypeToken<ArrayList<PcBang>>() {
        }.getType());
    }

    public static void main(String[] args) throws Exception {
        List<PcBang> pcBangs = readPcBangsFromResourceFile();
        for (PcBang pcBang : pcBangs) {
            pcBang.setName(pcBang.getName().replaceAll("é", "e"));
        }
        PcBangService pcBangService = new PcBangService(pcBangs);

        System.out.println("--- PC방 혜택 판별기 ---");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("플레이어의 IP주소를 입력하세요 (그만하려면 q): ");
            String next = scanner.next();
            if (next.contentEquals("q")) {
                break;
            }

            Player player = new Player();
            player.setIpAddr(next);

            System.out.println("-> 플레이어의 혜택은 " + pcBangService.getRewardsOfPlayer(player) + "입니다.");
        }

        System.out.println("--- APPLICATION TERMINATED ---");
    }

}
