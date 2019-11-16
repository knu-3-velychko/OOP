package XML;

import Entities.DiamondFund;
import Entities.Gem;
import Entities.Preciousness;
import Entities.VisualParameters;

public class DiamondFundXMLBuilder {
    private Type state = Type.Empty;

    private DiamondFund diamondFund = new DiamondFund();
    private Gem gem = null;
    private VisualParameters visualParameters = new VisualParameters();


    DiamondFundXMLBuilder addOpenTag(String tag) {
        state = getType(tag);

        if (state == Type.Gem) {
            gem = new Gem();
        } else if (state == Type.VisualParameters) {
            visualParameters = new VisualParameters();
        }
        return this;
    }

    DiamondFundXMLBuilder addAttribute(String name, String value) {
        if (value == null) value = "";

        if (name.equalsIgnoreCase("id"))
            gem.setId(value);
        return this;
    }

    DiamondFundXMLBuilder addData(String data) {
        switch (state) {
            case Name:
                gem.setName(data);
                break;
            case Preciousness:
                gem.setPreciousness(Preciousness.valueOf(data));
                break;
            case Origin:
                gem.setOrigin("data");
                break;
            case Color:
                visualParameters.setColor(data);
                break;
            case Opacity:
                visualParameters.setOpacity(Float.parseFloat(data));
                break;
            case CutType:
                visualParameters.setCutType(Integer.parseInt(data));
                break;
            case Value:
                gem.setValue(Float.parseFloat(data));
                break;
            default:
                break;
        }
        return this;
    }

    DiamondFundXMLBuilder addCloseTag(String tag) {
        return this;
    }

    DiamondFund getRoot() {
        return diamondFund;
    }

    private Type getType(String tag) {
        Type[] types = Type.values();

        for (Type type : types) {
            if (tag.equalsIgnoreCase(type.toString())) {
                state = type;
                return type;
            }
        }
        return Type.Empty;
    }
}
