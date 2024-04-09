package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynom {
  private Map<Integer, Double> polynom = new TreeMap<>();

  public Polynom (String polynomStr){
    Pattern patternOfPolynom = Pattern.compile( "([-+]?)(\\d+?)?\\s?\\*?\\s?[xX](\\^(\\d+))|(([-+]?)(\\d+))");
    Matcher isAMatch = patternOfPolynom.matcher(polynomStr);
    while (isAMatch.find()) {
        String coefficientPolStringSign = isAMatch.group(1);
        String coefficientPolStringDigit = isAMatch.group(2);
        String degreePolStringDigit = isAMatch.group(4);
        String freeCoefiStringSing = isAMatch.group(6);
        String freeCoefiStringDigit = isAMatch.group(7);
        int coefficient = (coefficientPolStringDigit != null) ? Integer.parseInt(coefficientPolStringDigit) : 1;
        int degree = (degreePolStringDigit != null) ? Integer.parseInt(degreePolStringDigit) : 0;
        if (coefficientPolStringSign != null && coefficientPolStringSign.equals("-")) {
            coefficient = -coefficient;
        }
        if (freeCoefiStringDigit != null) {
            coefficient = Integer.parseInt(freeCoefiStringDigit);
            degree = 0;
            if (freeCoefiStringSing != null) {
                if (freeCoefiStringSing.equals("-")) {
                    coefficient = -coefficient;
                }
            }
        }
        this.polynom.put(degree, this.polynom.getOrDefault(degree, (double)0) + coefficient);
    }
  }

  public void addPolynom (Map<Integer,Double> secPolynom){
      for(Map.Entry<Integer,Double> e : secPolynom.entrySet()){
        double coeff = e.getValue();
        int degree = e.getKey();
        this.polynom.put(degree, this.polynom.getOrDefault(degree, (double)0) + coeff);
      }

  }

  public void substarctPolynom (Map<Integer,Double> secPolynom){
    for(Map.Entry<Integer,Double> e : secPolynom.entrySet()){
      double coeff = e.getValue();
      int degree = e.getKey();
      this.polynom.put(degree, this.polynom.getOrDefault(degree, (double)0) - coeff);
    }
  }

  public void multiplyPolynom (Map<Integer,Double> secPolynom){
      Map<Integer, Double> result = new TreeMap<>();
      for (Map.Entry<Integer, Double> entry1 : this.polynom.entrySet()) {
          int firstDegree = entry1.getKey();
          double firstCoeff = entry1.getValue();

          for (Map.Entry<Integer, Double> entry2 : secPolynom.entrySet()) {
              int secDegree = entry2.getKey();
              double secCoeff = entry2.getValue();

              int resultedDegree = firstDegree + secDegree;
              double resultedCoeff = firstCoeff * secCoeff;

              result.put(resultedDegree, result.getOrDefault(resultedDegree, (double)0) + resultedCoeff);
          }
      }

      this.polynom.clear();
      this.polynom.putAll(result);
  }

  public void derivativeOfPolynom (){
      Map<Integer, Double> resultDer = new TreeMap<>();
      for(Map.Entry<Integer,Double> temp : this.polynom.entrySet()){
          double coeff = temp.getValue();
          int degree = temp.getKey();

          double resultedCoeff = coeff * degree;
          int resultedDegree = degree - 1;

          resultDer.put(resultedDegree, resultDer.getOrDefault(resultedDegree, (double)0) + resultedCoeff);
      }
      this.polynom.clear();
      this.polynom.putAll(resultDer);
  }
  public static double round(double coeff, int precision) {
        double prec = Math.pow(10, precision);
        return Math.round(coeff * prec) / prec;
  }
  public void integrateThePolynom (){
        Map<Integer, Double> resultInt = new TreeMap<>();
        for(Map.Entry<Integer,Double> temp : this.polynom.entrySet()){
            double coeff = temp.getValue();
            int degree = temp.getKey();

            double resultedCoeff =   coeff / (degree + 1);
            int resultedDegree = degree + 1;
            if((int)resultedCoeff == resultedCoeff){
                resultInt.put(resultedDegree, resultInt.getOrDefault(resultedDegree, (double)0) + resultedCoeff);
            }
            else resultInt.put(resultedDegree, resultInt.getOrDefault(resultedDegree,(double)0) + round(resultedCoeff, 2));
        }
        this.polynom.clear();
        this.polynom.putAll(resultInt);
  }
  private int maxDegree(Map<Integer,Double> polynomToFind){
        int degree = 0;
        for(Map.Entry<Integer,Double> temp : polynomToFind.entrySet()){
            if(temp.getKey() > degree && temp.getValue() != 0){
                degree = temp.getKey();
            }
        }
        return degree;
  }

  @Override
  public String toString(){
    StringBuilder resultedPol = new StringBuilder();
    String temp;
    boolean firstTerm = true;
    TreeMap<Integer, Double> invertedPol = new TreeMap<>(this.polynom);
    Map<Integer,Double> conv = invertedPol.descendingMap();
      for(Map.Entry<Integer,Double> e : conv.entrySet()){
        double coeff = e.getValue();
        int degree = e.getKey();
        if(firstTerm){
            if(degree == 0){
                if(coeff == 0) resultedPol.append("0");
                else resultedPol.append(coeff);
            }
            else {
                if(coeff == 0){
                    resultedPol.append("0");
                    continue;
                }
                if(coeff == 1) resultedPol.append("x^").append(degree).append("+");
                else if(coeff == -1) resultedPol.append("-x^").append(degree).append("+");
                else if(coeff == (int)coeff) resultedPol.append((int)coeff).append("x^").append(degree).append("+");
                else resultedPol.append(coeff).append("x^").append(degree).append("+");
            }
            if(coeff == 0){
                continue;
            }
        }
        if(degree != 0 && !firstTerm){
            if(coeff < 0){
                if(coeff == -1){
                    resultedPol.delete(resultedPol.length()-1,resultedPol.length());
                    resultedPol.append("-x^").append(degree).append("+");
                }
                else {
                    resultedPol.delete(resultedPol.length() - 1, resultedPol.length());
                    if(coeff == (int)coeff) resultedPol.append((int)coeff).append("x^").append(degree).append("+");
                    else resultedPol.append(coeff).append("x^").append(degree).append("+");
                }
            }
            else if (coeff > 0) {
                if(coeff == 1){
                    resultedPol.append("x^").append(degree).append("+");
                }
                else if(coeff == (int)coeff) resultedPol.append((int)coeff).append("x^").append(degree).append("+");
                else resultedPol.append(coeff).append("x^").append(degree).append("+");
            }
            if(coeff == 0){
                continue;
            }
       }
        if(degree == 0 && !firstTerm) {
            if(coeff < 0){
                resultedPol.delete(resultedPol.length()-1,resultedPol.length());
                if(coeff == (int)coeff) resultedPol.append((int)coeff);
                else resultedPol.append(coeff);
            }
            else if(coeff > 0) {
                if(coeff == (int)coeff) resultedPol.append((int)coeff);
                else resultedPol.append(coeff);
            }
            else resultedPol.delete(resultedPol.length()-1,resultedPol.length());
        }
        firstTerm = false;
      }
      temp = resultedPol.toString();
      if(!temp.isEmpty()){
          if(temp.charAt(temp.length()-1) == '0') {
              if(temp.length() != 1){
                temp = temp.substring(0,temp.length()-2);
              }
          }
          else if(temp.charAt(temp.length()-1) == '+') temp = temp.substring(0,temp.length()-1);
      }
      if(!temp.isEmpty()){
          if(temp.charAt(0) == '0'){
              if(temp.length() != 1 && temp.charAt(1) != '.') {
                  temp = temp.substring(1);
              }
          }
      }
      return temp;
  }
    public String dividePolynomBy (Map<Integer,Double> secondPoly) {
        Map<Integer, Double> q = new TreeMap<>();
        Map<Integer, Double> r = new TreeMap<>(this.polynom);
        StringBuilder resultString = new StringBuilder();
        while (!r.isEmpty() && (maxDegree(r) >= maxDegree(secondPoly))) {
            double coeffTemp = r.get(maxDegree(r)) / secondPoly.get(maxDegree(secondPoly));
            int degreeCoeff = maxDegree(r) - maxDegree(secondPoly);
            q.put(degreeCoeff, q.getOrDefault(degreeCoeff, (double) 0) + coeffTemp);
            Map<Integer, Double> result = new TreeMap<>();
            for(Map.Entry<Integer,Double> t : q.entrySet()) {
                int degreeQ = t.getKey();
                double coeffQ = t.getValue();
                for (Map.Entry<Integer, Double> term : secondPoly.entrySet()) {
                    int degree = term.getKey() + degreeQ;
                    double coeff = term.getValue() * coeffQ;
                    result.put(degree, r.getOrDefault(degree, (double) 0 + coeff));
                }
            }
            for (Map.Entry<Integer, Double> e : result.entrySet()) {
                double coeff = e.getValue();
                int degree = e.getKey();
                r.put(degree, r.getOrDefault(degree, (double) 0) - coeff);
            }
        }
        this.polynom.clear();
        this.polynom.putAll(q);
        resultString.append(this);
        this.polynom.clear();
        this.polynom.putAll(r);;
        resultString.append(" rest ").append(this);
        return resultString.toString();
    }

  public boolean textVerify (String textVeryfy){
      boolean test = true;
      for(char temp : textVeryfy.toCharArray()){
          if(temp != 'x' && !(temp >= 48 && temp <= 57) && temp != 'X' && temp != '^' && temp != '-' && temp != '+' && temp != '*'){
              test = false;
              break;
          }
      }
      return test;
  }

  public Map<Integer, Double> getPolynom() {
    return this.polynom;
  }
}
