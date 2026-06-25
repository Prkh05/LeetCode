/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let map = new Map ([
       [')', '('],
       ['}', '{'],
       [']', '[']
    ]);

    let stack = [];
    for(let i=0;i<s.length;i++){
        let char = s[i];
        if(char === '(' || char === '{' || char === '['){
            stack.push(char);
        }
        else{
            if(stack.length === 0) return false;
            let top = stack.pop();
            if(map.get(char)!==top) return false;
        }
    }
    return stack.length === 0;
};