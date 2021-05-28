package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;

public class LetterListModel implements LetterListContract.Model {

  public static String TAG = LetterListModel.class.getSimpleName();

  private List<LetterData> letras;
  private String data;
  private int alphabetPosition = 0;

  public LetterListModel(String data) {
    this.data = data;
  }

  @Override
  public String getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public List<LetterData> add(){
    if(letras==null){
      letras = new ArrayList<>();
    }
    LetterData letterData = new LetterData();
    letras.add(letterData);
    letterData.setAlphabetPosition(alphabetPosition+1);
    this.alphabetPosition = letterData.getAlphabetPosition();
    Log.e(TAG, "posicion es "+ letterData.getAlphabetPosition());
    return letras;
  }

  @Override
  public void onRestartScreen(String data) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(String data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }
}
