package Entities;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiamondFund {
    private List<Gem> gems;

    public DiamondFund() {
        gems = new ArrayList<>();
    }

    public DiamondFund(List<Gem> gems) {
        this.gems = gems;
    }

    public void addGem(Gem gem) {
        gems.add(gem);
    }

    public List<Gem> getGems() {
        return gems;
    }

    public void sortGems() {
        Collections.sort(gems);
    }
}
