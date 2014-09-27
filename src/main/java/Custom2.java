public class Custom2 {

  private final String value1;
  private final String value2;

  public static Custom2 parse(String value) {
    String[] strings = value.split(":");
    return new Custom2(strings[0], strings[1]);
  }

  // XXX
  // If the constructor is goes private, MyServer fails to start.
  public Custom2(String value) {
    Custom2 c = parse(value);
    this.value1 = c.getValue1();
    this.value2 = c.getValue2();
  }

  public Custom2(String value1, String value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  public String getValue1() {
    return value1;
  }

  public String getValue2() {
    return value2;
  }

}
