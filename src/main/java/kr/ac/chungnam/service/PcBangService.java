package kr.ac.chungnam.service;

import kr.ac.chungnam.domain.PcBang;
import kr.ac.chungnam.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class PcBangService {
    private List<PcBang> pcBangs;

    public PcBangService(List<PcBang> pcBangs) {
        this.pcBangs = pcBangs;
    }

    public List<String> getRewardsOfPlayer(Player player) {
        return new ArrayList<>();
    }
}
