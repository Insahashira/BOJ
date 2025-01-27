#include <iostream>
using namespace std;

int main(){
    string name, grade;
    float credit;
    float totalGrade = 0;
    float totalCredit = 0.0;

    for(int i = 0; i < 20; i++) {
        cin >> name >> credit >> grade;
        if (grade != "P") totalCredit += credit;
        if (grade == "A+") totalGrade += 4.5 * credit;
        else if (grade == "A0") totalGrade += 4.0 * credit;
        else if (grade == "B+") totalGrade += 3.5 * credit;
        else if (grade == "B0") totalGrade += 3.0 * credit;
        else if (grade == "C+") totalGrade += 2.5 * credit;
        else if (grade == "C0") totalGrade += 2.0 * credit;
        else if (grade == "D+") totalGrade += 1.5 * credit;
        else if (grade == "D0") totalGrade += 1.0 * credit;
        else continue;
    }
    cout << totalGrade / totalCredit << endl;
}