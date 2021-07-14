package con.stone.controller;

import con.stone.view.AbstractView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractControllerImpl<Model,View extends AbstractView<Model>> implements AbstractController<Model,View>{
    private Model model;
    private View view;

    public AbstractControllerImpl() {
        Class<Model> modelClass= (Class<Model>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Class<View> viewClass= (Class<View>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        model= (Model) getInstance(modelClass);
        view = (View) getInstance(viewClass);
    }

    private Object getInstance(Class<?> className){
        try {
            return className.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public void setModel(Model model) {
        this.model=model;
    }

    @Override
    public View getView() {
        return this.view;
    }

    @Override
    public void setView(View view) {
        this.view=view;
    }

    @Override
    public void printDetails(Model model) {
        view.printDetails(model);
    }

    @Override
    public void printDetails(List<Model> modelList) {
        view.printDetails(modelList);
    }
}
