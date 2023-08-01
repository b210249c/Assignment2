public class DiplomaData {
    private String category;
    private String name;
    private int total;
    private int max;
    private int min;

    public DiplomaData( String category, String name, int total, int max, int min){
        this.category = category;
        this.name = name;
        this.total = total;
        this.max = max;
        this.min = min;
    }
    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Category = "+category+", Name = "+name+", Total = "+total+", Maximum = "+max+", Minimum = "+min;
    }
}
