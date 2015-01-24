import java.util.Date;

public class MyDataObject {
    @Value(name = "someId")
    private Integer someId;

    @Value(name = "anyString")
    private String anyString;

    @Value(name = "anyBoolean")
    private Boolean anyBoolean;

    private Date someDate;

    public Integer getSomeId() {
        return someId;
    }

    public void setSomeId(Integer someId) {
        this.someId = someId;
    }

    public String getAnyString() {
        return anyString;
    }

    public void setAnyString(String anyString) {
        this.anyString = anyString;
    }

    public Boolean getAnyBoolean() {
        return anyBoolean;
    }

    public void setAnyBoolean(Boolean anyBoolean) {
        this.anyBoolean = anyBoolean;
    }

    public Date getSomeDate() {
        return someDate;
    }

    public void setSomeDate(Date someDate) {
        this.someDate = someDate;
    }
}
