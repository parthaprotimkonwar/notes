package application.enums;

/**
 * Created by pkonwar on 4/16/2016.
 */
public enum STATUS {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    private String status = null;

    STATUS(String type) {
        this.status = type;
    }

    public String getStatus() {
        return status;
    }
}
