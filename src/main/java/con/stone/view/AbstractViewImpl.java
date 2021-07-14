package con.stone.view;

import java.util.List;

public abstract class AbstractViewImpl<T> implements AbstractView<T> {

    @Override
    public void printDetails(List<T> modelList) {
        for (T model:modelList){
            printDetails(model);
        }
    }
}
