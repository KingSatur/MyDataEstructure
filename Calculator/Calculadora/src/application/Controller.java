package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.RationalNumber;

public class Controller {

    @FXML
    private Button substract;
    @FXML
    private Button four;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button addition;
    @FXML
    private Button nine;
    @FXML
    private Button six;
    @FXML
    private Button eight;
    @FXML
    private Button one;
    @FXML
    private Button five;
    @FXML
    private Button seven;
    @FXML
    private Button square;
    @FXML
    private Button simplify;
    @FXML
    private Button division;
    @FXML
    private TextField numerator1;
    @FXML
    private TextField denominator1;
    @FXML
    private TextField operation;
    @FXML
    private TextField numerator2;
    @FXML
    private TextField denominator2;
    @FXML
    private TextField equals;
    @FXML
    private TextField numeratorResult;
    @FXML
    private TextField denominatorResult;
    @FXML
    private Button go;
    @FXML
    private Button back;
    private boolean add;
    private boolean subs;
    private boolean divi;
    private boolean multi;
    private boolean simpli;
    private boolean squa;
    
    
    @FXML
    void setOne(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 1);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 1);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 1);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 1);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    	
    }
    
    @FXML
    void setSeven(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 7);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 7);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 7);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 7);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    }

    @FXML
    void setSix(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 6);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 6);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 6);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 6);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    }

    @FXML
    void setThree(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 3);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 3);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 3);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 3);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    }

    @FXML
    void setTwo(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 2);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 2);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 2);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 2);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    }
    
    @FXML
    void setEight(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 8);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 8);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 8);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 8);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    }

    @FXML
    void setFive(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 5);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setText(denominator1.getText() + 5);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setText(numerator2.getText() + 5);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setText(denominator2.getText() + 5);
    		denominator2.setEditable(false);
    	}
    }

    @FXML
    void setFour(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 4);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 4);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 4);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 4);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    	
    }

    @FXML
    void setNine(ActionEvent event) {
    	if(numerator1.isEditable()) {
    		numerator1.setText(numerator1.getText() + 9);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    		numerator2.setEditable(false);
    		numerator1.setEditable(false);
    	}
    	if(denominator1.isEditable()) {
    		denominator1.setText(denominator1.getText() + 9);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    	}
    	if(numerator2.isEditable()) {
    		numerator2.setText(numerator2.getText() + 9);
    		numerator1.setEditable(false);
    		denominator2.setEditable(false);
    		denominator1.setEditable(false);
    		numerator2.setEditable(false);
    	}
    	if(denominator2.isEditable()) {
    		denominator2.setText(denominator2.getText() + 9);
    		numerator1.setEditable(false);
    		numerator2.setEditable(false);
    		denominator1.setEditable(false);
    		denominator2.setEditable(false);
    	}
    }

    @FXML
    void isGoPressed(ActionEvent event) {
    	if(simpli || squa) {
			equals.setVisible(true);
			numeratorResult.setVisible(true);
			denominatorResult.setVisible(true);
			if(simpli) {
				RationalNumber<Number> m = new RationalNumber<Number>(Integer.parseInt(numerator1.getText()) ,Integer.parseInt(denominator1.getText()));
				m.simplifyRational();
				numeratorResult.setText(String.valueOf(m.getNumerator()));
				denominatorResult.setText(String.valueOf(m.getDenominator()));
				
			}
			else {
				RationalNumber<Number> m = new RationalNumber<Number>(Integer.parseInt(numerator1.getText()) ,Integer.parseInt(denominator1.getText()));
				m.squaredRational();
				numeratorResult.setText(String.valueOf(m.getNumerator()));
				denominatorResult.setText(String.valueOf(m.getDenominator()));
			}
    	}
    	else {
    		if(operation.isVisible() && numerator2.isVisible() && denominator2.isVisible()) {
    			if(!(numerator2.getText().equals("")) && !(denominator2.getText().equals("")) && !(numerator1.getText().equals("")) && !(denominator1.getText().equals(""))) {
    				equals.setVisible(true);
    				numeratorResult.setVisible(true);
    				denominatorResult.setVisible(true);
    				if(add) {
    					RationalNumber<Number> m = new RationalNumber<Number>(Integer.parseInt(numerator1.getText()) ,Integer.parseInt(denominator1.getText()));
    					m.addRational(new RationalNumber<Number>(Integer.parseInt(numerator2.getText()), Integer.parseInt(denominator2.getText())) );
    					numeratorResult.setText(String.valueOf(m.getNumerator()));
    					denominatorResult.setText(String.valueOf(m.getDenominator()));
    				}
    				if(subs) {
    					RationalNumber<Number> m = new RationalNumber<Number>(Integer.parseInt(numerator1.getText()) ,Integer.parseInt(denominator1.getText()));
    					m.substractRational(new RationalNumber<Number>(Integer.parseInt(numerator2.getText()), Integer.parseInt(denominator2.getText())) );
    					numeratorResult.setText(String.valueOf(m.getNumerator()));
    					denominatorResult.setText(String.valueOf(m.getDenominator()));
    				}
    				if(divi) {
    					RationalNumber<Number> m = new RationalNumber<Number>(Integer.parseInt(numerator1.getText()) ,Integer.parseInt(denominator1.getText()));
            			m.divideRational(new RationalNumber<Number>(Integer.parseInt(numerator2.getText()), Integer.parseInt(denominator2.getText())) );
            			numeratorResult.setText(String.valueOf(m.getNumerator()));
            			denominatorResult.setText(String.valueOf(m.getDenominator()));
    				}
    				if(multi) {
    					RationalNumber<Number> m = new RationalNumber<Number>(Integer.parseInt(numerator1.getText()) ,Integer.parseInt(denominator1.getText()));
    					m.multiplyRational(new RationalNumber<Number>(Integer.parseInt(numerator2.getText()), Integer.parseInt(denominator2.getText())) );
    					numeratorResult.setText(String.valueOf(m.getNumerator()));
    					denominatorResult.setText(String.valueOf(m.getDenominator()));
    				}
    				if(simpli) {
            		
    				}
    				if(squa) {
            		
    				}
    			}
    		}
    		
    	}
 
    }
    

    @FXML
    void isBackPressed(ActionEvent event) {
    	operation.setVisible(false);
    	numerator2.setVisible(false);
    	numerator2.setText("");
    	denominator2.setVisible(false);
    	denominator2.setText("");
    	numeratorResult.setVisible(false);
    	denominatorResult.setVisible(false);
    	equals.setVisible(false);
    }

    
    @FXML
    void isClickedNumerator1(MouseEvent event) {
    	numerator1.setEditable(true);
    }
	

    @FXML
    void isClickedDenominator1(MouseEvent event) {
    	denominator1.setEditable(true);
    	
    }
    
    @FXML
    void isClickedNumerator2(MouseEvent event) {
    	numerator2.setEditable(true);
    }
    
    @FXML
    void isClickedDenominator2(MouseEvent event) {
    	denominator2.setEditable(true);
    }
    
    @FXML
    void isDivisionPressed(ActionEvent event) {
    	divi = true;
    	multi = false;
    	add = false;
    	subs = false;
    	squa = false;
    	simpli = false;
    	operation.setVisible(true);
    	operation.setText(" ÷ ");
    	numerator2.setVisible(true);
    	denominator2.setVisible(true);
    	
    }

    @FXML
    void isMultiplyPressed(ActionEvent event) {
    	multi = true;
    	divi = false;
    	add = false;
    	subs = false;
    	squa = false;
    	simpli = false;
    	operation.setVisible(true);
    	operation.setText(" * ");
    	numerator2.setVisible(true);
    	denominator2.setVisible(true);
    }
    
    @FXML
    void isSimplifyPressed(ActionEvent event) {
    	simpli = true;
    	multi = false;
    	divi = false;
    	add = false;
    	subs = false;
    	squa = false;
    	operation.setVisible(true);
    	operation.setText(" simpli ");
    }

    @FXML
    void isSquarePressed(ActionEvent event) {
    	squa = true;
    	multi = false;
    	divi = false;
    	add = false;
    	subs = false;
    	simpli = false;
    	operation.setVisible(true);
    	operation.setText(" ^2 ");
    }

    @FXML
    void isSubstractPressed(ActionEvent event) {
    	subs = true;
    	multi = false;
    	divi = false;
    	add = false;
    	squa = false;
    	simpli = false;
    	operation.setVisible(true);
    	operation.setText(" - ");
    	numerator2.setVisible(true);
    	denominator2.setVisible(true);
    }
    

    @FXML
    void isAdditionPressed(ActionEvent event) {
    	add = true;
    	multi = false;
    	divi = false;
    	subs = false;
    	squa = false;
    	simpli = false;
    	operation.setVisible(true);
    	operation.setText(" + ");
    	numerator2.setVisible(true);
    	denominator2.setVisible(true);
    }

}
