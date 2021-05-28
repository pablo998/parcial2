package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;

public class LetterListModel implements LetterListContract.Model {

  public static String TAG = LetterListModel.class.getSimpleName();

  private List<LetterData> letras;
  private int data;
  private int alphabetPosition = 0;

  public LetterListModel() {

  }

  @Override
  public int getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public void setStoredData(int data) {
    // Log.e(TAG, "getStoredData()");
    this.data = data;
  }

  @Override
  public List<LetterData> add(){
    if(letras==null){
      letras = new ArrayList<>();
    }
    LetterData letterData = new LetterData(this.alphabetPosition);
    letras.add(letterData);
    letterData.setAlphabetPosition(alphabetPosition+1);
    this.alphabetPosition = letterData.getAlphabetPosition();
    if( this.alphabetPosition == letterData.getAlphabet().length ){
      this.alphabetPosition = 0;
    }
    Log.e(TAG, "posicion es ahora "+ letterData.getAlphabetPosition());
    return letras;
  }

  @Override
  public void onRestartScreen(int data) {
    // Log.e(TAG, "onRestartScreen()");
    this.data = data;
  }

  @Override
  public void onDataFromNextScreen(int data) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.data = data;
    Log.e(TAG, "Numero guardado " + this.data);
  }

  @Override
  public void onDataFromPreviousScreen(int data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }
}
