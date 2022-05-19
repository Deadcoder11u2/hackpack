#include <bits/stdc++.h>
using namespace std;
#define NO_OF_CHARS 256
int getNextState(string needle, int m, int state, int x)
{
    if (state < m && x == needle[state])
        return state+1;
    int ns, i;
    for (ns = state; ns > 0; ns--)
    {
        if (needle[ns-1] == x)
        {
            for (i = 0; i < ns-1; i++)
                if (needle[i] != needle[state-ns+1+i])
                    break;
            if (i == ns-1)
                return ns;
        }
    }
    return 0;
}
void computeTF(string needle, int m, int TF[][NO_OF_CHARS])
{
    int state, x;
    for (state = 0; state <= m; ++state)
        for (x = 0; x < NO_OF_CHARS; ++x)
            TF[state][x] = getNextState(needle, m, state, x);
}
void search(string haystack, string needle)
{
    int n = haystack.size();
    int m = needle.size();
    set<char> unique ;
    for(auto i : needle)
    {
        unique.insert(i) ;
    }
    vector<char> uniqel ;
    for(auto i : unique)
    {
        uniqel.push_back(i) ;
    }
    int TF[m+1][NO_OF_CHARS];
    computeTF(needle, m, TF);
    cout << " " ;
    for(auto i : uniqel)
    {
        cout << i << " " ;
    }
    cout << endl << endl ;
    for(int i = 0 ; i<m+1 ; i++)
    {
        cout << i << " " ;
        for(auto j : uniqel)
        {
            cout << TF[i][j] << " " ;
        }
        cout << endl ;
    }
    cout << endl ;
    vector<int> ans ;
    int i, state=0;
    for(auto i : haystack)
    {
        cout << i << " " ;
    }
    cout << endl ;
    for (i = 0; i < n; i++)
    {
        state = TF[state][haystack[i]];
        cout << state << " " ;
        if (state == m)
            ans.push_back(i-m+1) ;
    }
    cout << endl << endl ;
    for(auto i : ans)
    {
        cout << "The required string was found at " ;
        cout << i << endl ;
    }
}
int main()
{
    string haystack , needle ;
    cin >> haystack >> needle ;
    search(haystack, needle);
}
