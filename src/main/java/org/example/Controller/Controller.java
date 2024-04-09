package org.example.Controller;

import org.example.Model.Polynom;
import org.example.View.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    MainView pv;
    public Controller (MainView view) {
        this.pv = view;


        pv.getAddButton().addActionListener(this);
        pv.getDivideByButton().addActionListener(this);
        pv.getIntegrateButton().addActionListener(this);
        pv.getIntegrateFrameButton().addActionListener(this);
        pv.getMultiplyByButton().addActionListener(this);
        pv.getSubstractButton().addActionListener(this);
        pv.getEqualButton().addActionListener(this);
        pv.getDerivateFrameButton().addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == pv.getIntegrateButton()){
            pv.getIntegrationFrame().setVisible(true);
            pv.getAllFrame().setEnabled(false);
            pv.getIntegrationFrame().getWindowListeners();
        }
        if(e.getSource() == pv.getEqualButton()){
            pv.getDerivativeFrame().setVisible(true);
            pv.getAllFrame().setEnabled(false);
            pv.getDerivativeFrame().getWindowListeners();
        }
        if(e.getSource() == pv.getAddButton()){
            Polynom firstPol = new Polynom(pv.getFirstPolinom().getText());
            Polynom secondPol = new Polynom(pv.getSecondPolinom().getText());
            if(pv.getFirstPolinom().getText().isEmpty() || !(firstPol.textVerify(pv.getFirstPolinom().getText())) || !((firstPol.textVerify(pv.getSecondPolinom().getText())))){
                pv.getAllFrame().setEnabled(false);
                pv.getInvalidInputFrame().setVisible(true);
            }
            else {
                firstPol.addPolynom(secondPol.getPolynom());
                pv.getResultPolinom().setText(firstPol.toString());
            }
        }
        if(e.getSource() == pv.getSubstractButton()){
            Polynom firstPol = new Polynom(pv.getFirstPolinom().getText());
            Polynom secondPol = new Polynom(pv.getSecondPolinom().getText());
            if(pv.getFirstPolinom().getText().isEmpty() || !(firstPol.textVerify(pv.getFirstPolinom().getText())) || !((firstPol.textVerify(pv.getSecondPolinom().getText())))){
                pv.getAllFrame().setEnabled(false);
                pv.getInvalidInputFrame().setVisible(true);
            }
            else {
                firstPol.substarctPolynom(secondPol.getPolynom());
                pv.getResultPolinom().setText(firstPol.toString());
            }
        }
        if(e.getSource() == pv.getMultiplyByButton()){
            Polynom firstPol = new Polynom(pv.getFirstPolinom().getText());
            Polynom secondPol = new Polynom(pv.getSecondPolinom().getText());
            if(pv.getFirstPolinom().getText().isEmpty() || !(firstPol.textVerify(pv.getFirstPolinom().getText())) || !((firstPol.textVerify(pv.getSecondPolinom().getText())))){
                pv.getAllFrame().setEnabled(false);
                pv.getInvalidInputFrame().setVisible(true);
            }
            else {
                firstPol.multiplyPolynom(secondPol.getPolynom());
                pv.getResultPolinom().setText(firstPol.toString());
            }
        }
        if(e.getSource() == pv.getDerivateFrameButton()){
            Polynom polToDerivate = new Polynom(pv.getDerivativeTF().getText());
            if(pv.getDerivativeTF().getText().isEmpty() || !(polToDerivate.textVerify(pv.getFirstPolinom().getText()))){
                pv.getAllFrame().setEnabled(false);
                pv.getInvalidInputFrame().setVisible(true);
            }
            else {
                polToDerivate.derivativeOfPolynom();
                pv.getDerivativeResTF().setText(polToDerivate.toString());
            }
        }
        if(e.getSource() == pv.getIntegrateFrameButton()){
            Polynom polToIntegrate = new Polynom(pv.getIntegrationTF().getText());
            if(pv.getIntegrationTF().getText().isEmpty() || !(polToIntegrate.textVerify(pv.getFirstPolinom().getText()))){
                pv.getAllFrame().setEnabled(false);
                pv.getInvalidInputFrame().setVisible(true);
            }
            else {
                polToIntegrate.integrateThePolynom();
                pv.getIntegrationResTF().setText(polToIntegrate.toString());
            }
        }
        if(e.getSource() == pv.getDivideByButton()){
            Polynom firstPol = new Polynom(pv.getFirstPolinom().getText());
            Polynom secondPol = new Polynom(pv.getSecondPolinom().getText());
            if(pv.getFirstPolinom().getText().isEmpty() || !(firstPol.textVerify(pv.getFirstPolinom().getText())) || !((firstPol.textVerify(pv.getSecondPolinom().getText()))) || (pv.getSecondPolinom().getText().equals("0"))){
                pv.getAllFrame().setEnabled(false);
                pv.getInvalidInputFrame().setVisible(true);
            }
            else {
                if(pv.getSecondPolinom().getText().equals("1")){
                    pv.getResultPolinom().setText(firstPol.toString() + " rest " + 0);
                }
                else pv.getResultPolinom().setText(firstPol.dividePolynomBy(secondPol.getPolynom()));
            }
        }
    }


}
