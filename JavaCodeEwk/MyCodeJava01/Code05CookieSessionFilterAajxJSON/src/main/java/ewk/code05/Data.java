package ewk.code05;

public class Data {
    private Integer id;
    private String name;
    private Integer age;
    private String bir;

    public Data() {

    }

    public Data(Integer id, String name, Integer age, String bir) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir='" + bir + '\'' +
                '}' + "\n";
    }
}
