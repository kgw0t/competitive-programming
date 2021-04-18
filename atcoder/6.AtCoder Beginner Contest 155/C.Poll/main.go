package main

import (
	"fmt"
	"sort"
)

func main() {
	var N int
	fmt.Scan(&N)

	S := make([]string, N)
	m := make(map[string]int)
	max := 0
	for i, _ := range S {
		fmt.Scan(&S[i])
		m[S[i]]++
		if max < m[S[i]] {
			max = m[S[i]]
		}
	}

	k := make([]string, 0)
	for key, _ := range m {
		k = append(k, key)
	}

	sort.Strings(k)

	for _, key := range k {
		if m[key] == max {
			fmt.Println(key)
		}
	}

}
