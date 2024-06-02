import request from '@/utils/request'

export function getAllHotel(data){
  return request({
    url:'/getAllHotel',
    method: 'get',
      params: data
  })
}
