public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        if (data.size() == 0) {
            System.out.println("Empty list");
            return Double.NaN;
        }
        
        double max = Double.NEGATIVE_INFINITY;
        MyIterator iterator = data.iterator();
        
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        if (data.size() == 0) {
            System.out.println("Empty list");
            return Double.NaN;
        }
        
        double min = Double.POSITIVE_INFINITY;
        MyIterator iterator = data.iterator();
        
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            if (value < min) {
                min = value;
            }
        }
        
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        if (data.size() == 0) {
            System.out.println("Empty list");
            return Double.NaN;
        }
        
        double sum = 0;
        int count = 0;
        MyIterator iterator = data.iterator();
        
        while (iterator.hasNext()) {
            sum += iterator.next().doubleValue();
            count++;
        }
        
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        if (data.size() == 0) {
            System.out.println("Empty list");
            return Double.NaN;
        }
        
        double mean = mean();
        double sumSquaredDifferences = 0;
        int count = 0;
        MyIterator iterator = data.iterator();
        
        while (iterator.hasNext()) {
            double value = iterator.next().doubleValue();
            sumSquaredDifferences += Math.pow(value - mean, 2);
            count++;
        }
        
        return sumSquaredDifferences / count;
    }
}
