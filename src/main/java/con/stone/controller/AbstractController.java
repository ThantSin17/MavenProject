package con.stone.controller;

import con.stone.view.AbstractView;

public interface AbstractController<Model,View extends AbstractView<Model>> extends AbstractView<Model> {
    Model getModel();
    void  setModel(Model model);

    View getView();
    void setView(View view);
}
