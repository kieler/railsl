/**
 * generated by Xtext 2.37.0
 */
package de.cau.cs.kieler.railsl.railSL.impl;

import de.cau.cs.kieler.railsl.railSL.RailSLPackage;
import de.cau.cs.kieler.railsl.railSL.TimeWaitStatement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Wait Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.cau.cs.kieler.railsl.railSL.impl.TimeWaitStatementImpl#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeWaitStatementImpl extends WaitStatementImpl implements TimeWaitStatement
{
  /**
   * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected static final int TIME_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected int time = TIME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeWaitStatementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RailSLPackage.Literals.TIME_WAIT_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getTime()
  {
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTime(int newTime)
  {
    int oldTime = time;
    time = newTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RailSLPackage.TIME_WAIT_STATEMENT__TIME, oldTime, time));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RailSLPackage.TIME_WAIT_STATEMENT__TIME:
        return getTime();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RailSLPackage.TIME_WAIT_STATEMENT__TIME:
        setTime((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RailSLPackage.TIME_WAIT_STATEMENT__TIME:
        setTime(TIME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RailSLPackage.TIME_WAIT_STATEMENT__TIME:
        return time != TIME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (time: ");
    result.append(time);
    result.append(')');
    return result.toString();
  }

} //TimeWaitStatementImpl
