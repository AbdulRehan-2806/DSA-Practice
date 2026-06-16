class Solution:
    def calculateScore(self, instructions: List[str], values: List[int]) -> int:
        size=len(instructions)
        ind=0
        ans=0
        visited=set()
        while('sga'):
            if ind<0 or ind>=size or ind in visited:
                break
            visited.add(ind)
            if instructions[ind]=='jump':
                ind+=values[ind]
            else:
                ans+=values[ind]
                ind+=1
        return ans
                