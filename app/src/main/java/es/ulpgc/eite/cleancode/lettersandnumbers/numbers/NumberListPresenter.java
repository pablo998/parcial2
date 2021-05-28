package es.ulpgc.eite.cleancode.lettersandnumbers.numbers;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.lettersandnumbers.app.AppMediator;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.LettersToNumbersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.NumbersToLettersState;
import es.ulpgc.eite.cleancode.lettersandnumbers.data.NumberData;

public class NumberListPresenter implements NumberListContract.Presenter {

  public static String TAG = NumberListPresenter.class.getSimpleName();

  private WeakReference<NumberListContract.View> view;
  private NumberListState state;
  private NumberListContract.Model model;
  private AppMediator mediator;

  public NumberListPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getNumberListState();
  }


  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new NumberListState();
    }

    // use passed state if is necessary
    LettersToNumbersState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      Log.e(TAG, "el numero recibido es " + savedState.data);
      model.onDataFromPreviousScreen(savedState.data);
    }

  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.contadorGlobal);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    /*
    // use passed state if is necessary
    NumberListState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromNextScreen(savedState.data);
    }
    */

    // call the model and update the state
    state.contadorGlobal = model.getStoredData();
    state.datasource = model.getNumbers();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
    NumbersToLettersState numbersToLettersState = new NumbersToLettersState();
    numbersToLettersState.data = state.contadorGlobal;
    passStateToPreviousScreen(numbersToLettersState);
    int numero = state.contadorGlobal;
    Log.e(TAG, "Numeroglobar es " + numero);
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }


  /*
  private void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, NumberListActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  private void passStateToNextScreen(NumberListState state) {
    mediator.setNextNumberListScreenState(state);
  }


  private NumberListState getStateFromNextScreen() {
    return mediator.getNextNumberListScreenState();
  }
  */

  private void passStateToPreviousScreen(NumbersToLettersState state) {
    mediator.setPreviousNumberListScreenState(state);
  }

  private LettersToNumbersState getStateFromPreviousScreen() {
    return mediator.getPreviousNumberListScreenState();
  }

  @Override
  public void onClickNumberListCell(NumberData data) {
    // Log.e(TAG, "onClickNumberListCell()");
  }

  @Override
  public void onClickNumberListButton() {
    // Log.e(TAG, "onClickNumberListButton()");
    state.datasource = model.add();
    state.contadorGlobal = model.getStoredData();
    view.get().onDataUpdated(state);
  }

  @Override
  public void injectView(WeakReference<NumberListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(NumberListContract.Model model) {
    this.model = model;
  }

}
