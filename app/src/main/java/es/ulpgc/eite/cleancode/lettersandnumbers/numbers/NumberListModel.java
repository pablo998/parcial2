package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.lettersandnumbers.data.LetterData;
import es.ulpgc.eite.cleancode.lettersandnumbers.data.NumberData;

public class NumberListModel implements NumberListContract.Model {

  public static String TAG = NumberListModel.class.getSimpleName();

  private int data = 1;
  private List<NumberData> numeros = new ArrayList<>();


  public NumberListModel() {

  }

  @Override
  public int getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return this.data;
  }

  @Override
  public List<NumberData> add(){
    NumberData numberData = new NumberData(data);
    numeros.add(numberData);
    this.data = this.data+1;
    Log.e(TAG, "el numero es " + this.data);
    return numeros;
  }

  @Override
  public List<NumberData> getNumbers(){
    return numeros;
  }

  @Override
  public void onRestartScreen(int data) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(int data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(int data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    if(this.data > 1) {
      this.data = data;
    }
  }
}
